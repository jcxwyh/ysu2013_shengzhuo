package pro.onlyou.ysu2013.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtils {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    /**
     * 加密原始密码
     * @param rawPassword
     * @return
     */
    public static String encoder(String rawPassword){
        return ENCODER.encode(rawPassword);
    }

    /**
     * 验证密码是否一致
     * @param rawPassword   原始密码
     * @param crytoPassword 加密密码
     * @return
     */
    public static boolean valid(String rawPassword,String crytoPassword){
        return ENCODER.matches(rawPassword,crytoPassword);
    }
}
