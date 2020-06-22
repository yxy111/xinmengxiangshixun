/**
 * Created by bdqn on 2016/5/3.
 */
//登录的方法
function login() {
    var loginName = $("#loginName").val();
    var password = $("#password").val();

    // $.ajax({
    //     url: contextPath + "/login",
    //     method: "post",
    //     data: {
    //         loginName: loginName,
    //         password: password
    //     }, success: function (jsonStr) {
    //         console.log(jsonStr);
    //         var result = eval("(" + jsonStr + ")");
    //         if (result.status === 1) {
    //             window.location.href = contextPath + "/home/index";
    //         } else {
    //             showMessage(result.message)
    //         }
    //     }
    // });

    var form = new FormData();
    form.append("loginName", loginName);
    form.append("password", password);

    var settings = {
        "url": contextPath + "/login",
        "method": "POST",
        "timeout": 0,
        "processData": false,
        "mimeType": "multipart/form-data",
        "contentType": false,
        "data": form,
    };

    $.ajax(settings).done(function (response) {
        var result = eval("(" + response + ")");
        if (result.status === 1) {
            console.log("ok")
            window.location.href = contextPath + "/home/index";
        } else {
            showMessage(result.message)
        }
    });
}