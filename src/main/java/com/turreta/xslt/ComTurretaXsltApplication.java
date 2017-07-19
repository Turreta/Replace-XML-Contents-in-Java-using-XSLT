package com.turreta.xslt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

@SpringBootApplication
public class ComTurretaXsltApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComTurretaXsltApplication.class, args);

		Source inputXml = new StreamSource(new File("C:\\Users\\xxxx\\Desktop\\test-data\\input.xml"));
		Source xsl = new StreamSource(new File("C:\\Users\\xxxx\\Desktop\\test-data\\translation.xsl"));
		Result outputXml = new StreamResult(new File("C:\\Users\\xxxx\\Desktop\\test-data\\output.xml"));

		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
			transformer.setParameter("headingPrefix", "CONFIDENTIAL");
			transformer.setParameter("bodyDisclaimer", "Please do not print!");
			transformer.transform(inputXml, outputXml);
		} catch (TransformerException e) {
			e.getMessage();
		}
	}
}
