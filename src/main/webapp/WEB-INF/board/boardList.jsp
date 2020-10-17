<%@ page import="org.diary4us.dao.BoardInformDao" %>
<%@ page import="org.diary4us.dto.BoardInform" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="org.diary4us.config.DBconfig" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
    <link rel="stylesheet" href="/static/css/main.css">
    <title>diary4us</title>
    <script src="/includeHTML.js"></script>

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
        <table id="board-table" >
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성일</th>
                <th>내용</th>
            </tr>
            </thead>
            <tbody>
            <%
                ApplicationContext ac = new AnnotationConfigApplicationContext(DBconfig.class);
                BoardInformDao boardInformDao = ac.getBean(BoardInformDao.class);
                ArrayList<BoardInform> list = (ArrayList<BoardInform>) boardInformDao.selectSome();
                for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td>
                    <%=list.get(i).getBoardId()%>
                </td>
                <td style="text-align: left; padding-left: 10px">
                    <a href="/board/boardView.jsp?boardId=<%=list.get(i).getBoardId()%>">
                        <%=list.get(i).getTitle()%>
                    </a>
                </td>

                <td>
                    <%=list.get(i).getRegdate() %>
                </td>
                <td>
                    <%
                        int temp = list.get(i).getContent().length();
                        if (temp > 20) temp = 20; %>
                    <%=list.get(i).getContent().substring(0, temp) %>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <br>
        <!-- page indexing -->

        <!-- new diary write -->
    </div>

</main>
<!-- footer -->
<footer include-html="/footer.html"></footer>
<script src="/static/js/main.js"></script>
<script>
    includeHTML();
</script>
</body>

</html>