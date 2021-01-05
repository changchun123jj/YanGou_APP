package com.example.demo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

import jcifs.UniAddress;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import jcifs.smb.SmbSession;

/**
 * 文件控件
 *
 * @author liaoc
 */
public class UtilFile {
    /**
     * 获取文件流(根目录为classPath)
     *
     * @param path
     * @return
     */
    public static InputStream getResourceInputStream(String path) {
        InputStream fileIs = UtilFile.class.getResourceAsStream(path);
        return fileIs;
    }

    /**
     * 获取文件url(根目录为classPath)
     *
     * @param path
     * @return
     */
    public static URL getResource(String path) {
        URL url = UtilFile.class.getResource(path);
        return url;
    }

    /**
     * 获取文件路径
     *
     * @param path
     * @return
     */
    public static String getResourcePath(String path) {
        URL url = UtilFile.class.getResource(path);
        return url.getFile();
    }

    public static byte[] getContext(String fileName) throws IOException {
        byte[] result = null;
        File file = new File(fileName);
        if (file.exists()) {
            ByteArrayOutputStream resStream = new ByteArrayOutputStream(1000 * 1000 * 20);
            FileInputStream fis = new FileInputStream(file);
            byte[] temp = new byte[1000];
            int i = 0;
            while ((i = fis.read(temp)) != -1) {
                resStream.write(temp, 0, i);
            }
            fis.close();
            result = resStream.toByteArray();
            resStream.close();
        }
        return result;
    }

    /**
     * 文件复制
     *
     * @param fileName     文件名称
     * @param folderSource 源路径
     * @param folderTarget 目标路径
     * @param isCover      是否强制覆盖
     */
    public static void copyFile(String fileName, String folderSource, String folderTarget, boolean isCover)
            throws ServiceException {
        // 数据校验
        // - 源文件
        File filePathSource = new File(folderSource + "/" + fileName);
        if (null != filePathSource && !filePathSource.exists()) {
            throw new ServiceException(RetCode.CONFIG_ERROR, "源文件(" + folderSource + "/" + fileName + ")不存在！");
        }
        // - 目标目录
        File dicTarget = new File(folderTarget);
        if (null != dicTarget && !dicTarget.exists()) {
            throw new ServiceException(RetCode.CONFIG_ERROR, "目标目录(" + dicTarget + ")不存在！");
        }
        // - 目标文件
        File filePathTarget = new File(folderTarget + "/" + fileName);
        boolean isNeedCopy = true;
        if (filePathTarget.exists()) {
            // - - 文件存在
            if (isCover) {
                isNeedCopy = true;
            } else {
                isNeedCopy = false;
            }
        } else {
            // - - 文件不存在
            isNeedCopy = true;
        }
        // 复制
        if (isNeedCopy) {
            InputStream in = null;
            OutputStream out = null;
            int byteRead = 0; // 读取的字节数
            try {
                in = new FileInputStream(filePathSource);
                out = new FileOutputStream(filePathTarget);
                byte[] buffer = new byte[1024]; // 读缓存
                while ((byteRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, byteRead);
                }
            } catch (FileNotFoundException fnfe) {
                throw new ServiceException(RetCode.NOT_EXIST, "文件未找到！", fnfe);
            } catch (IOException ioe) {
                throw new ServiceException(RetCode.FAIL, "文件复制失败！", ioe);
            } finally {
                try {
                    if (out != null)
                        out.close();
                    if (in != null)
                        in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 创建文件
     *
     * @param filePath
     * @param bytes
     * @throws ServiceException
     */
    public static void writeFile(String filePath, byte[] bytes) throws ServiceException {
        // 数据校验
        // - 路径
        if (null == filePath || "".equals(filePath)) {
            throw new ServiceException(RetCode.PARAMETER_ERROR, "路径错误！");
        }
        // - 目录
        filePath = filePath.replace("\\", "/");
        File dic = new File(filePath.substring(0, filePath.indexOf("/")));
        if (null == dic || !dic.exists()) {
            throw new ServiceException(RetCode.CONFIG_ERROR, "目录(" + dic + ")不存在！");
        }
        // - 字节流
        if (null == bytes || bytes.length < 0) {
            throw new ServiceException(RetCode.PARAMETER_ERROR, "数据错误！");
        }
        // 写文件
        File file = null;
        FileOutputStream out = null;
        try {
            file = new File(filePath);
            out = new FileOutputStream(file);
            out.write(bytes);
        } catch (Exception e) {
            throw new ServiceException(RetCode.FAIL, "创建文件失败！", e);
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * 创建文件
     *
     * @param hostRemote 共享主机地址（如：192.168.100.65）
     * @param dicRemote  共享目录（如：tempFolder）
     * @param fileName   文件名称
     * @param bytes      文件字节流
     * @param user       共享主机用户
     * @param pwd        共享主机密码
     * @throws ServiceException
     */
    public static void writeFileRemot(String hostRemote, String dicRemote, String fileName, byte[] bytes, String user,
                                      String pwd) throws ServiceException {
        // 数据校验
        if (null == dicRemote) {
            dicRemote = "";
        }
        // - 字节流
        if (null == bytes || bytes.length < 0) {
            throw new ServiceException(RetCode.PARAMETER_ERROR, "数据错误！");
        }
        // 写文件
        OutputStream out = null;
        try {
            // String remoteUrl = "smb://" + user + ":" + pwd + "@" + hostRemote
            // + "/" + dicRemote;
            // SmbFile remoteFile = new SmbFile(remoteUrl + "/" + fileName);

            InetAddress ip = InetAddress.getByName(hostRemote);
            UniAddress myDomain = new UniAddress(ip);
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(hostRemote, user, pwd); // 先登录验证
            SmbSession.logon(myDomain, auth);
            SmbFile remoteFile = new SmbFile("smb://" + hostRemote + "/" + dicRemote, auth);

            remoteFile.connect();
            out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
            out.write(bytes);
            out.flush();
        } catch (Exception e) {
            throw new ServiceException(RetCode.FAIL, "创建文件失败！", e);
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * 获取文件内容（字符串）
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static String getFileContent(String fileName) throws ServiceException {
        StringBuffer result = new StringBuffer();
        // 数据校验
        // - 源文件
        File file = new File(fileName);
        if (null != file && !file.exists()) {
            throw new ServiceException(RetCode.CONFIG_ERROR, "源文件(" + fileName + ")不存在！");
        }
        // 读取文件内容
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while (null != (line = br.readLine())) {
                result.append(line);
            }
        } catch (FileNotFoundException e) {
            throw new ServiceException(RetCode.FAIL, "获取文件内容失败！", e);
        } catch (IOException e) {
            throw new ServiceException(RetCode.FAIL, "获取文件内容失败！", e);
        } finally {
            try {
                br.close();
            } catch (Exception e) {
            }
        }
        return result.toString();
    }

    /**
     * 下载文件
     *
     * @param filePath
     * @param url
     * @throws ServiceException
     * @throws IOException
     */
    public static void downloadFile(String filePath, String url) throws ServiceException, IOException {
        // 数据校验
        if (null == filePath || "".equals(filePath)) {
            throw new ServiceException(RetCode.PARAMETER_ERROR, "文件路径错误！");
        }
        filePath = filePath.replace("\\", "/");
        // - 源目录
        String folderStr = filePath.substring(0, filePath.lastIndexOf("/"));
        if (!new File(folderStr).exists()) {
            new File(folderStr).mkdirs();
        }
        // 下载
        // - 建立连接
        URL fileUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) fileUrl.openConnection();
        conn.setRequestMethod("GET"); // 请求方式
        conn.setConnectTimeout(1000 * 3); // 超时时间
        conn.setRequestProperty("Charset", "UTF-8"); // 字符编码
        conn.connect();
        // - 生成文件
        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
        OutputStream os = new FileOutputStream(filePath);
        byte[] buf = new byte[1024];
        int size = 0;
        while ((size = bis.read(buf)) != -1) {
            os.write(buf, 0, size);
        }
        // - 关闭
        bis.close();
        os.close();
    }

    public static byte[] getFileByte(String filePath) throws ServiceException, IOException {
        byte[] result = null;
        // 数据校验
        if (null == filePath || "".equals(filePath)) {
            throw new ServiceException(RetCode.PARAMETER_ERROR, "文件路径错误！");
        }
        // 转化
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bufferByte = new byte[1024];
        int bufferLen = 0;
        while ((bufferLen = fis.read(bufferByte)) != -1) {
            bos.write(bufferByte, 0, bufferLen);
        }
        fis.close();
        bos.close();
        result = bos.toByteArray();
        // 返回
        return result;
    }

    public static void isChartPathExist(String dirPath) {

        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


}
