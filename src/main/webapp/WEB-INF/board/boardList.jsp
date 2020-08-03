<%@ page import="org.diary4us.dao.BoardInformDao" %>
<%@ page import="org.diary4us.dto.BoardInform" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.sql.SQLFeatureNotSupportedException" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./static/css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
    <title>diary4us</title>
    <script src="./includeHTML.js"></script>
</head>

<body>
    <header>
        <h1>Diary 4 Us <i class="fas fa-book"></i></h1>
        <h2>우리사이의 다이어리</h2>

    </header>
    <main>
        <!-- navigator -->
        <header include-html="./nav.html"></header>

        <div id="main-main">
            <div>반갑습니다. 일기를 읽어보아요.</div>
            <button class="btn-diary" onclick="refresh()">새로고침</button>

            <!-- board area -->


            <!-- 게시판 -->
            <table style="height: 100%; width: 800px;padding:  3px; text-align:center; border:1px solid #dddddd">
                <thead>
                    <tr>
                        <th style="background-color: #eeeeee; text-align: center;">번호</th>
                        <th style="background-color: #eeeeee; text-align: center;">제목</th>
                        <th style="background-color: #eeeeee; text-align: center;">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        DataSource temp = new DataSource() {
                            @Override
                            public Connection getConnection() throws SQLException {
                                return null;
                            }

                            @Override
                            public Connection getConnection(String username, String password) throws SQLException {
                                return null;
                            }

                            @Override
                            public PrintWriter getLogWriter() throws SQLException {
                                return null;
                            }

                            @Override
                            public void setLogWriter(PrintWriter out) throws SQLException {

                            }

                            @Override
                            public void setLoginTimeout(int seconds) throws SQLException {

                            }

                            @Override
                            public int getLoginTimeout() throws SQLException {
                                return 0;
                            }

                            @Override
                            public <T> T unwrap(Class<T> iface) throws SQLException {
                                return null;
                            }

                            @Override
                            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                                return false;
                            }

                            @Override
                            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                                return null;
                            }
                        };
                    BoardInformDao boardInformDao = new BoardInformDao(temp);
                    ArrayList<BoardInform> list = (ArrayList<BoardInform>) boardInformDao.selectAll();
                    for (int i = 0; i < list.size(); i++) {
                    %>
                        <tr>
                            <td>
                                <%=list.get(i).getBoardId()%>
                            </td>
                            <td style="text-align: left; padding-left: 10px">
                                <a href="${pageContext.request.contextPath}/board/boardView.jsp?boardId=<%=list.get(i).getBoardId()%>">
                                    <%=list.get(i).getTitle()%>
                                </a>
                            </td>

                            <td>
                                <%=list.get(i).getRegdate() %>
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
    <footer include-html="./footer.html"></footer>
    <script src="../static/js/main.js"></script>
    <script>
        includeHTML();
    </script>
</body>

</html>