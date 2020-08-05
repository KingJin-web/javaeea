package D0528;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig()
@WebServlet("/upload.s")
public class Upload extends HttpServlet {
    private static final long serialVersionUID = 1L;

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Part part = req.getPart("file");
//        part.getName();
//        String filename = part.getSubmittedFileName();
//        part.getSize();
//        part.write("D:/" + filename);
//        resp.getWriter().append("文件上传成功");
//    }
//

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        part.getName();
        String filename = part.getSubmittedFileName();
        part.getSize();
        part.write("D:/" + filename);
        resp.getWriter().append("文件上传成功");
    }
}
