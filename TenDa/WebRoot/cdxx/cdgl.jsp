<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>线路管理</title>
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
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center">&quot;<img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 车队信息->车队管理</span></td>
              </tr>
            </table></td>
            <td><br><div align="right"><span class="STYLE1">
              
          </span></div><br></tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车队编号</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车队名称</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车队负责人</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
      
      <c:forEach var="motorcade" items="${MotorcadeList}">
      <tr>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${motorcade.motorcadeNum }</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${motorcade.motorcadeName }</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${motorcade.chargeId }</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
      	 <a href="cdxx/cdscServlet?Num=${motorcade.motorcadeNum }">删除</a>
        </div></td>
        
      </tr>
     </c:forEach>
    </table></td>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong> 243</strong> 条记录，当前第<strong> 1</strong> 页，共 <strong>10</strong> 页</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="49"><div align="center"><img src="images/main_56.gif" width="40" height="15" /></div></td>
            <td width="49"><div align="center"><img src="images/main_56.gif" width="45" height="15" /></div></td>
            <td width="49"><div align="center"><img src="images/main_58.gif" width="45" height="15" /></div></td>
            <td width="49"><div align="center"><img src="images/main_56.gif" width="40" height="15" /></div></td>
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
            <td width="22"><div align="center">
              <input type="text" name="textfield" id="textfield"  style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;"/>
            </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
            <td width="35"><img src="images/main_56.gif" width="26" height="15" /></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>

<form action="cdxx/cdtjServlet" method="post">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center">&quot;<img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 车队信息->车队添加</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="image" src="images/add_on.gif" width="60" height="19"  /> <span class="STYLE1"> &nbsp;</span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      
      <tr>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">车队名称</span></div></td>
        <td  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">
        	<input type="text" name="motorcadeName"/>
        </span></div></td>
      </tr>
     
      <tr>
        <td height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE19">车队负责人</span></div></td>
        <td height="20" bgcolor="d3eaef" class="STYLE19"><div align="center">
         <select name="chargeId">
        		<option value="EP1101">admin</option>
        		<option value="EP1102">展昭</option>
        		<option value="EP1103">manager</option>
        		<option value="EP1104">小昭</option>
        		<option value="EP1105">赵敏</option>
        		
        	</select>
        </div></td>
        
      </tr>
     
      
     
    </table></td>
  </tr>
  
</table>
</form>
</body>
</html>

