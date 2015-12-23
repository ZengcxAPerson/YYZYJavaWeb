<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>货源添加</title>
	<style type="text/css">
	<!--
	body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	}
	.STYLE1 {
		color: #e1e2e3;
		font-size: 12px;
	}
	.STYLE6 {color: #000000; font-size: 12; }
	.STYLE10 {color: #000000; font-size: 12px; }
	.STYLE19 {
		color: #344b50;
		font-size: 12px;
	}
	.STYLE21 {
		font-size: 12px;
		color: #3b6375;
	}
	.STYLE22 {
		font-size: 12px;
		color: #295568;
	}
	-->
	</style>
</head>

<body>



<form action="cdxx/cltjServlet" method="post">
<table width="40%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center">&quot;<img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 车队信息->车辆管理->车辆添加</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="image" src="images/add.gif" width="10" height="10" /> <span class="STYLE1"> 添加&nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td  height="20" width="70" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车辆车牌号</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="licenseplate" size="25"/>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车队名称</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="motorcadeNum">
        		<option value="CTI0901">飞豹</option>
        		<option value="MTC-0002">闪电</option>
        		<option value="MTC-0003">猎鹰</option>
        	</select>
        </span></div>
        </td>
     </tr>
     
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车辆名称</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="trademark" size="25"/>
        </span></div>
        </td>
     </tr>
     
     
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车辆类型</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="type">
        		<option value="重车">重车</option>
        		<option value="面包">面包</option>
        		<option value="五菱">五菱</option>
        	</select>
        </span></div>
        </td>
     </tr>
     
     
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车辆限重（吨）</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="weightlimit" size="25"/>
        </span></div>
        </td>
     </tr>
     
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车辆使用时间（年）</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="usagetime" size="25"/>
        </span></div>
        </td>
     </tr>
     
     
    
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车主驾龄</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="drivingexperience">
        		<option value="1-5年">1-5年</option>
        		<option value="5-10年">5-10年</option>
        		<option value="9年">9年</option>
        	</select>
        </span></div>
        </td>
     </tr>
     
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">驾驶证号</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<input type="text" name="licenceNumber" size="25"/>
        </span></div>
        </td>
     </tr>
     
    <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">驾驶证类型</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="licenceStyle">
        		<option value="身份证">身份证</option>
        		<option value="户口本">户口本</option>
        		<option value="9年">9年</option>
        	</select>
        </span></div>
        </td>
     </tr>
     
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">运输类型</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div ><span class="STYLE10">
        	<select name="transpotStyle">
        		<option value="国外长途">国外长途</option>
        		<option value="省内长途">省内长途</option>
        	</select>
        </span></div>
        </td>
     </tr>
     <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车辆备注</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="left"><span class="STYLE10">
        	<textarea cols="10" size="12" name="remark">
			
			</textarea>
        </span></div></td>
      </tr>
           
      </table>
      </td>
  </tr>
 
   
</table>
</form>
	<img src="images/car.jpg" />
</body>
</html>