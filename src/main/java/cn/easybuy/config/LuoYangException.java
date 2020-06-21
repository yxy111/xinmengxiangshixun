package cn.easybuy.config;


import lombok.Data;

/**
 * @author luoyang
 */
@Data
public class LuoYangException extends  RuntimeException{

    //状态码
    private Integer code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public LuoYangException(Integer code, String message) {
        super(message);
        this.code=code;
    }

    @Override
    public String toString() {
        return "LuoYangException{" +
                "code=" + code +
                '}';
    }
}
