package cn.easybuy.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 罗阳
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("easybuy_user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "登录名")
    @TableField("loginName")
    private String loginName;

    @ApiModelProperty(value = "用户名")
    @TableField("userName")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别(1:男 0：女)")
    private Integer sex;

    @ApiModelProperty(value = "身份证号")
    @TableField("identityCode")
    private String identityCode;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "类型（1：后台 0:前台）")
    private Integer type;


}
