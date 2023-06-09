<%--
  Created by IntelliJ IDEA.
  User: jihunkim
  Date: 2023/04/01
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 목록</title>
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

        tbody tr  td:nth-of-type(2) {
            text-align: left;
        }

        a {
            text-decoration: none;
            color: black;
        }

        a:hover {
            color: red;
        }
    </style>
    <!-- 페이징 처리 style -->
    <style>
        .pagination {
            margin: 0 auto;
            display: flex;
            justify-content: center;
        }

        .pagination a {
            color: black;
            float: left;
            padding: 4px 8px;
            text-decoration: none;
            transition: background-color .3s;
        }

        .pagination a.active {
            background-color: dodgerblue;
            color: white;
        }

        .pagination a:hover:not (.active ) {
            background-color: #ddd;
        }
    </style>
    <style>
        .searchWord {
            background-color: yellow;
            color: red;
        }
    </style>
    <style>
        .title {
            display: inline-block;
            white-space: nowrap;
            width: 90%;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
</head>
<body>

<div align="center">
    <h2><a class="btn btn-secondary" href="/board/list" id="homeLink">목록 보기</a></h2>
    <a href="/board/write">글쓰기</a>
    <table style="width:600px;">
        <thead>
        <tr>
            <th width="10%">번호</th>
            <th width="45%">제목</th>
            <th width="17%">작성자</th>
            <th width="20%">등록일</th>
            <th width="10%">조회</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${ not empty boardList }">

                <c:forEach items="${ boardList }" var="board">
                    <tr>
                        <td>${ board.BId }</td>
                        <td><a href="/board/view?seq=${board.BId}">${board.title }</a></td>
                        <td><a href="mailto:${ board.email }">${ board.writer }</a></td>
                        <td>${ board.writedate }</td>
                        <td>${ board.readed }</td>
                    </tr>
                </c:forEach>

            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5">등록된 게시글이 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="5" align="center">
                <div class="pagination">
                    <c:if test="${ pageBlock.prev }">
                        <a href="/board/list?currentpage=${  pageBlock.startOfPageBlock - 1  }"> &laquo; </a>
                    </c:if>
                    <c:forEach begin="${  pageBlock.startOfPageBlock  }" end="${  pageBlock.endOfPageBlock  }" var="i" step="1">
                        <c:choose>
                            <c:when test="${ pageBlock.currentPage eq i }">
                                <a href="#" class="active">${ i }</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/board/list?currentpage=${ i }">${ i }</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${ pageBlock.next }">
                        <a href="/board/list?currentpage=${  pageBlock.endOfPageBlock + 1  }"> &raquo; </a>
                    </c:if>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="5" align="center">
                <form method="get">
                    <select name="searchCondition" id="searchCondition">
                        <option value="1">title</option>
                        <option value="2">content</option>
                        <option value="3">writer</option>
                        <option value="4">title+content</option>
                    </select>
                    <input type="text" name="searchWord" id="searchWord" />
                    <input type="submit" value="search" />
                </form>
            </td>
        </tr>
        </tfoot>
    </table>
</div>

<script>
    if ('<%=  request.getParameter("delete") %>' == 'success') {
        alert("글 삭제 완료!!!")
    } else if ('<%=  request.getParameter("delete") %>' == 'fail') {
        alert("글 삭제 실패( 비밀번호 잘못)!!!")
    }
</script>

<script>
    // 검색 상태 관리
    $("#searchCondition").val(   '${  empty param.searchCondition? 1 :  param.searchCondition }'        );
    $("#searchWord").val( '${ param.searchWord}' );
</script>

<script>
    $(".pagination a:not(.active)").attr("href" , function (i,val){
        return val + "&searchCondition=${ param.searchCondition}&searchWord=${ param.searchWord}";
    });
</script>