<%--
  Created by IntelliJ IDEA.
  User: 12613
  Date: 2020/5/15
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>省市县联动</title>
  <style type="text/css">
    select{
      width:100px
    }
  </style>
  <script type="text/javascript" src="vue.min.js"></script>
  <script type="text/javascript">
    function test(){
      /* var xhr=new XMLHttpRequest(); */
      xhr.onreadystatechange=function(){
        if(xhr.readyState==4&&xhr.status==200){
          var arr=xhr.responseText.split(",");
          console.info(arr);
        }
      }
      xhr.open("POST","/FistJavaEE_war_exploded/area.do");
      xhr.send("a=1&b=1");
    }
    function init(){
      loadSheng();
      loadShi(0);
      loadXian(0,0);
    }
    function loadSheng(){
      post("/FistJavaEE_war_exploded/area.do","level=0",function(text){
        var arr=text.split(",");
        vue.$data.shengItems=arr;

      });
    }
    function loadShi(shengIndex){
      if(shengIndex==undefined){
        shengIndex=0;
      }
      post("/FistJavaEE_war_exploded/area.do","level=1&shengIndex="+shengIndex,function(text){
        var arr=text.split(",");
        vue.$data.shiItems=arr;
      });
    }

    function loadXian(shengIndex,shiIndex){

      post("/FistJavaEE_war_exploded/area.do","level=2&shengIndex="+shengIndex+"&shiIndex="+shiIndex,function(text){
        var arr=text.split(",");
        vue.$data.xianItems=arr;
      });
    }
    //封装好的ajax代码
    function post(url,param,callback){
      var xhr
      try{
        xhr=new XMLHttpRequest();
      }catch(e){
        xhr=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xhr.onreadystatechange=function(){
        if(xhr.readyState==4&&xhr.status==200){
          callback(xhr.responseText);
        }
      }
      xhr.open("POST",url);
      //post提交数据的编码方式
      xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
      xhr.send(param);
    }
  </script>

</head>
<body onload="init()">
<div id="main">

  <h3>AJAX实现省市联动</h3>
  省:<select id="sheng" @change="changeSheng()">
  <option v-for="sheng in shengItems">{{sheng}}</option>
</select>
  市:<select id="shi" @change="changeShi()">
  <option v-for="shi in shiItems">{{shi}}</option>
</select>
  县:<select id="xian" >
  <option v-for="xian in xianItems">{{xian}}</option>
</select>
  <hr>

</div>
<script type="text/javascript">
  var vue=new Vue({
    el:"#main",
    data:{
      shengItems:[],
      shiItems:[],
      xianItems:[],
    },
    //事件函数
    created:function(){
      loadSheng();
      loadShi();
      loadXian();
    },
    methods:{
      changeSheng(){
        var sheng=document.getElementById("sheng");//==sheng
        loadShi(sheng.selectedIndex);//selectedIndex获取选中索引
        loadXian(sheng.selectedIndex,0);//
      },
      changeShi(){
        var sheng=document.getElementById("sheng");
        var shi=document.getElementById("shi");
        loadXian(sheng.selectedIndex,shi.selectedIndex);
      }
    }
  });
</script>
<dl>
  <dt>要求:
  <dd>
    <ol>
      <li>使用 AJAX 方式从后台获取省市县的数据, 加载到下拉列表选项中
      <li>在选择 省 和 市 时, 发送 AJAX 请求, 获取对应的 市 和 县 的数据, 加载到对应的下拉列表选项中
    </ol>
</dl>
<dl>
  <dt>提示: 关于数据返回格式
  <dd>
    <ol>
      <li>可以使用字符串拼接成一个字符串, 例如: "北京,天津,湖南,湖北...", 然后用JS进行字符串解析( split )
      <li>也可以考虑使用拼接 JSON 格式 字符串, 例如: "['北京','天津','湖南','湖北'....]", 然后用 eval 函数, 或 JSON.parse函数, 将其转换成 JS数组.
    </ol>
</dl>
</body>
</html>