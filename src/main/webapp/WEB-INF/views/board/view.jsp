<%--
  Created by IntelliJ IDEA.
  User: jihunkim
  Date: 2023/04/02
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글</title>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />
    <style>
    table {
        border-spacing: 3px;d
        border-collapse: separate;
    }

    table, tr, td {
        border: solid 1px gray;
        /* border-radius: 3px;
        padding:3px;   */
    }

    #tblContent {
        width: 600px;
    }
</style>

</head>
<body>
<div align="center">
    <h2>내용보기</h2>
    <!-- <table id="tblContent" class="table"> -->
    <table id="tblContent">
        <tr>
            <td>이름</td>
            <td>${ board.writer }</td>
            <td>등록일</td>
            <td>${ board.writedate }</td>
        </tr>
        <tr>
            <td>Email</td>
            <td><a href="mailto:${ board.email }">${ board.email }</a></td>
            <td>조회</td>
            <td>${ board.readed }</td>
        </tr>
        <tr>
            <td>제목</td>
            <td colspan="3">${ board.title }</td>
        </tr>
        <tr>
            <td colspan="4" style="padding:15px;height: 200px;text-align: left;vertical-align: top">
                ${ board.content }
            </td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <a class="btn btn-secondary" href="/board/edit?seq=${ board.BId }"
                   id="editLink">수정하기</a>
                <a class="btn btn-secondary" href="/board/list" id="homeLink">Home</a>

                <input class="btn btn-secondary" type="button" id="btnModalDelete" value="모달창으로 글삭제">
            </td>
        </tr>
    </table>
</div>

<!-- 삭제 모달창 div 태그 -->
<div id="dialog-form" align="center" title="삭제">
    <h2>삭제하기</h2>
    <form method="post" action="/board/delete?seq=${board.BId}">
        <table>
            <tr>
                <td colspan="2" align="center"><b>글을 삭제합니다</b></td>
            </tr>
            <tr>
                <td align="center">비밀번호</td>
                <td>
                    <input type="password" name="pwd" size="15" autofocus="autofocus">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="삭제">&nbsp;&nbsp;
                    <input type="button" id="cancel" value="취소">
                </td>
            </tr>
        </table>
    </form>
</div>

<script>
    // 1.
    dialog = $("#dialog-form").dialog({
        autoOpen: false,
        height: 400,
        width: 350,
        modal: true,
        buttons: {},
        close: function () {
            form[0].reset();
        }
    });

    form = dialog.find("form");

    // 3. 모달창 열기
    $("#btnModalDelete").on("click", function (event) {
        dialog.dialog("open");
    })
    // 4. 모달창 닫기
    $("#cancel").on("click", function (event) {
        dialog.dialog("close");
    })
</script>

