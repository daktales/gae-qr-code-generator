package it.daktales.gae.apps.gaeqrcodegeneratorapi;

import it.daktales.gae.libs.gaeqrcodegenerator.QrCode;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class QRCodeGeneratorAPI extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  
    // Check request path
    String pathInfo = request.getPathInfo();
    System.out.print(pathInfo);
    
    if (pathInfo == null || "".equals(pathInfo)){
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    
    QrCode qr = QrCode.encodeText(pathInfo.substring(1), QrCode.Ecc.LOW);

    response.setContentType("image/png");
    response.setStatus(HttpServletResponse.SC_OK);
    OutputStream stream = response.getOutputStream();
    stream.write(qr.toByteArray(10, 0));
    stream.close();
  }
}
