<%@ page import="org.diary4us.dao.BoardInformDao" %>
<%@ page import="org.diary4us.dto.BoardInform" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="org.diary4us.config.DBconfig" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/static/css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
    <title>diary4us</title>
    <script src="/includeHTML.js"></script>
    <link rel="stylesheet" href="/static/css/main.css">
</head>

<body>
<header>
    <h1>Diary 4 Us<i class="fas fa-book"></i></h1>
    <h2>우리사이의 다이어리</h2>
</header>
<main>
    <!-- navigator -->
    <header include-html="/nav.html"></header>

    <div id="main-main">
        <div>반갑습니다. 일기를 읽어보아요.</div>

        <!-- board area -->

        <!-- 게시판 -->
        <%
            ApplicationContext ac = new AnnotationConfigApplicationContext(DBconfig.class);
            BoardInformDao boardInformDao = ac.getBean(BoardInformDao.class);
            int boardId = 0;
            if (request.getParameter("boardId") != null) {
                boardId = Integer.parseInt(request.getParameter("boardId"));
            }
            if (boardId == 0) {
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('삭제된 글 입니다.')");
                script.println("location.href = './boardList.jsp'");
                script.println("</script>");
            }
            BoardInform boardInform = boardInformDao.selectById(boardId);
        %>
        <!-- 게시판 -->
        <div>
            <div>
                <table id="board-table-view">
                    <thead>
                    <tr>
                        <th colspan="3" style="background-color: #eeeeee; text-align: center; ">글 보기</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td style="width: 20%;"> 글 번호</td>
                        <td colspan="2">
                            <%= boardInform.getBoardId() %>
                        </td>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td colspan="2">
                            <%= boardInform.getTitle() %>
                        </td>
                    </tr>
                    <tr>
                        <td>작성일</td>
                        <td colspan="2">
                            <%= boardInform.getRegdate()%>
                        </td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td colspan="2" style="height: 270px; text-align: left;">
                            <%= boardInform.getContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") %>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <br>
                <div style="text-align: end">
                    <a href="./boardList.jsp">목록보기</a>
                </div>
            </div>
        </div>
        <br>
        <!-- page indexing -->

        <!-- new diary write -->
    </div>

</main>
<!-- footer -->
<footer include-html="../footer.html"></footer>
<script src="../static/js/main.js"></script>
<script>
    includeHTML();
</script>
</body>

</html>