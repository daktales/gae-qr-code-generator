gae-qr-code-generator
===
A library for generating QR Codes from Java App engine application.
 
![image](https://gae-qr-code-generator-api.appspot.com/qrcode/https://github.com/daktales/gae-qr-code-generator)

*This QR Code is generated by an app engine microservice using this library*

## Description
Google App Engine Java standard environment supports only a subset of Java 7 (full Java 8 support is in beta) classes so we need a workaround to create images without `java.awt.Image` or `java.awt.image.BufferedImage`.

This library uses [QR-Code-generator](https://github.com/nayuki/QR-Code-generator) and [PNGJ](https://github.com/leonbloy/pngj) to output QR Codes as SVG string and PNG (byte array and Base64 string).

## Usage
App engine servlet basic example

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  
    	QrCode qr = QrCode.encodeText("Hello world!", QrCode.Ecc.LOW);

    	response.setContentType("image/png");
    	response.setStatus(HttpServletResponse.SC_OK);
    	
    	OutputStream stream = response.getOutputStream();
    	stream.write(qr.toByteArray(10, 0));
    	stream.close();
    }
    
## Demo
Inside this repository there is an App Engine demo application (gae-qr-code-generator-api)