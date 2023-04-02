<%--
  Created by IntelliJ IDEA.
  User: jihunkim
  Date: 2023/04/03
  Time: 1:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시글 수정</title>
  <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
  <script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />
  <style>
    table, td, th {
      border: solid 1px gray;
    }

    table {
      border-spacing: 3px;
      border-collapse: separate;
    }

    table, tr, td {
      /* border-radius: 3px; */
      /* padding:3px;  */

    }
  </style>
</head>
<body>
<h3>edit.jsp</h3>

<div align="center">

  <form method="post">

    <table style="padding: 2px; width: 600px">
      <tr>
        <td colspan="2" align="center"><b>글을 수정합니다.</b></td>
      </tr>
      <tr>
        <td align="center">이름</td>
        <td><input type="text" name="writer" size="15"   value="${ board.writer }"   readonly="readonly"></td>
      </tr>
      <tr>
        <td align="center">비밀번호</td>
        <td><input type="password" name="pwd" size="15" required="required"></td>
      </tr>
      <tr>
        <td align="center">Email</td>
        <td><input type="email" name="email" size="50"   value="${ board.email }"></td>
      </tr>
      <tr>
        <td align="center">제목</td>
        <td><input type="text" name="title" size="50" required="required"  value="${ board.title }"  autofocus="autofocus"></td>
      </tr>
      <tr>
        <td align="center">내용</td>
        <td><textarea name="content" cols="50" rows="10">${ board.content }</textarea></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="작성 완료">
          &nbsp;&nbsp;&nbsp;
          <input type="button" onclick="history.back()" value="이전으로">
        </td>
      </tr>
    </table>

  </form>
</div>


<script>
  $(function (){
    $("form").submit(function (){
      alert("유효성 검사 체크 한다. ");
      // event.preventDefault();
      // return false;
    });
  });
</script>
</body>
</html>