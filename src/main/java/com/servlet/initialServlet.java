package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sun.net.httpserver.HttpContext;

import util.HibernateUtil;

/**
 * Servlet implementation class initialServlet
 */
public class initialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public initialServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpContext.Current.Response.ContentType = "application/pdf";
		HttpContext.Current.Response.AppendHeader( "Content-Disposition", "attachment; filename=test.pdf");


		using (MemoryStream myMemoryStream = new MemoryStream())
		{
		Document document = new Document();
		PdfWriter PDFWriter = PdfWriter.GetInstance(document, myMemoryStream);

		document.AddHeader("Content-Disposition", "attachment; filename=wissalReport.pdf");

		document.Open();

		  //..........

		document.Close();


		byte[] content = myMemoryStream.ToArray();
		HttpContext.Current.Response.Buffer = false;
		HttpContext.Current.Response.Clear();
		HttpContext.Current.Response.ClearContent();
		HttpContext.Current.Response.ClearHeaders();
		HttpContext.Current.Response.AppendHeader("content-disposition","attachment;filename=" + "my_report.pdf");
		HttpContext.Current.Response.ContentType = "Application/pdf";

		//Write the file content directly to the HTTP content output stream.
		HttpContext.Current.Response.BinaryWrite(content);
		HttpContext.Current.Response.Flush();
		HttpContext.Current.Response.End();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
