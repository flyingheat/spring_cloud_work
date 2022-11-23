
<html>

<head>
    <title>教师登录</title>
</head>


<!-- 导入Bootstrap CSS 文件 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<style>
    .back {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background-color: #E4E4E4;
        background-size: 100% 100%;
        background-repeat: no-repeat;
    }
    .container-round {
        background-color: rgba(255,255,255,0.5);
        width: 736px;
        border-radius: 10px;
        margin-top: 40px
    }
    #box {

        width: 87px;
        height: 50px;
        margin-left: 300px;

    }
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>

    function login(){

        $.ajax({
            url:"/student/userLogin",
            type:"post",
            data:$("form").serialize(),
            success:function (obj){
                if(obj == "true"){
                    alert("登陆成功")
                    location.href="/student/list";
                }else {
                    alert("登陆失败")
                }
            },
            dataType: "text",
        })
    }

</script>
<body class="back">

<table class="table table-hover">
</table>

<div class="container container-round">
    <h1 align="center" style="font-size: 30px">教师登录</h1>
    <form class="form-horizontal" role="form" style="margin-top: 20px">
        <div class="form-group">
            <label for="goodsName" class="col-sm-3 control-label">username:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="username" name="username" placeholder="username">
            </div>
        </div>

        <div class="form-group">
            <label for="price" class="col-sm-3 control-label">password:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="password" name="password" placeholder="password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-6" id="box">
                <input type="button" class="btn btn-info" value="登录" onclick="login()">
            </div>
        </div>
    </form>
</div>

</body>

</html>
