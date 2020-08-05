//package D0530;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//import java.io.IOException;
//
//@WebServlet("/0530/uploadSsq.do")
//public class UploadSsqSerblet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Part part = req.getPart("file");
//        String webpath = "/0530";
//        String disk = req.getServletContext().getRealPath(webpath);
//
//        System.out.println(disk);
//        part.write(disk + "/" + part.getSubmittedFileName());
//        resp.getWriter().append("ok");
//    }
//}
echo "# javaeea" >> README.md
        git init
        git add README.md
        git commit -m "first commit"
        git remote add origin https://github.com/KingJin-web/javaeea.git
        git push -u origin master
