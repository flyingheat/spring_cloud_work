<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>三级联动</title>
    <#--引入css样式-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

</head>

<script src="http://code.jquery.com/jquery-latest.js"></script>

<script>

    $(function() {

        /*通过pid来获取所有的省份的数据*/
        $.ajax({

            url:"/student/findCityById",

            type:"post",

            data:{pid:0},

            success:function (obj) {

                for(let i in obj) {

                    if(i == 0){

                        $("#one").append("<option selected value='"+obj[i].id+"'>"+obj[i].cName+"</option>")

                        twoCity(obj[i].id)

                    }else {

                        $("#one").append("<option value='"+obj[i].id+"'>"+obj[i].cName+"</option>")

                    }

                }

            },

            dataType:"json",

        })

        $.ajax({

            url:"/student/findAllClasses",

            type:"post",

            success:function (obj) {

                for(let i in obj) {

                    $("#classesId").append("<option value='"+obj[i].classId+"'>"+obj[i].className+"</option>")

                }

            },

            dataType:"json",

        })

        //绑定内容发生改变事件
        $("#one").change(function (){

            let id = $("#one option:selected").val()

            twoCity(id)

        })

        //绑定内容发生改变事件
        $("#two").change(function (){

            let id = $("#two option:selected").val()

            threeCity(id)

        })

        $("[value = '提交']").click(function () {

            $.ajax({

                url:"/student/addStudent",

                type:"post",

                data:$("form").serialize(),

                success:function (obj){
                    if(obj=="true"){
                        alert("添加成功")
                        //跳转一个
                        location.href="/student/list"
                    }else{
                        alert("添加失败")
                    }

                },

                dataType:"text",

            })


        })
    })


    function twoCity(pid){

        //清空所有元素
        $("#two").empty()

        $.ajax({

            url:"/student/findCityById",

            type: "post",

            data:{pid:pid},

            success:function (obj){

                for(let i in obj){

                    if(i == 0){

                        $("#two").append("<option value='"+obj[i].id+"'>"+obj[i].cName+"</option>")

                    }else {

                        $("#two").append("<option value='"+obj[i].id+"'>"+obj[i].cName+"</option>")

                    }

                }

            },

            dataType: "json"

        })

    }

    function threeCity(pid){

        $("#three").empty()

        $.ajax({

            url:"/student/findCityById",

            type: "post",

            data:{pid:pid},

            success:function (obj){

                for(let i in obj){

                    if(i == 0){

                        $("#three").append("<option value='"+obj[i].id+"'>"+obj[i].cName+"</option>")

                    }else {

                        $("#three").append("<option value='"+obj[i].id+"'>"+obj[i].cName+"</option>")

                    }

                }

            },

            dataType: "json"

        })

    }


</script>

<body>
<form>
    <table class="table table-hover">

        <tr>
            <td>学生姓名</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>

        <tr>
            <td>学生年龄</td>
            <td>
                <input type="text" name="age">
            </td>
        </tr>

        <tr>
            <td>学生爱好</td>
            <td>
                <input type="text" name="hobby">
            </td>
        </tr>

        <tr>
            <td>学生住址</td>
            <td>
                省：<select id="one" name="province">
                    <option>--请选择--</option>
                </select>

                市：<select id="two" name="city">
                    <option>--请选择--</option>
                </select>

                区：<select id="three" name="district">
                    <option>--请选择--</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>学生班级</td>
            <td>
                <select id="classesId" name="classId">
                    <option>--请选择--</option>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="11" align="center">
                <input type="button" value="提交">
            </td>
        </tr>
    </table>
</form>

</body>
</html>