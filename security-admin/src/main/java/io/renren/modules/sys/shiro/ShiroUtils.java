package io.renren.modules.sys.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author flyap
 * @email 927840351@qq.com
 * @date
 * @used
 */
public class ShiroUtils {
   /* 加密算法 */
    public  final  static String hashAlgorithmName="SHA-256";
    /*循环次数*/
    public  final static int hashIterations=16;

    public  static  String sha256(String password,String salt){
        return  new SimpleHash(hashAlgorithmName,password,salt,hashIterations).toString();
    }








}
