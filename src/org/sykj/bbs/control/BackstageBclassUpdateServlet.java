package org.sykj.bbs.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.sykj.bbs.dao.BclassDao;

/**
 * Servlet implementation class BackstageBclassUpdateServlet
 */
@WebServlet("/backstageBclassUpdateServlet")
public class BackstageBclassUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackstageBclassUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("update");
			List<String> fileName=new ArrayList<String>();
			List<String> values=new ArrayList<String>();
			 try {
				 //磁盘文件工厂
				 DiskFileItemFactory factory = new DiskFileItemFactory();
				 // Servlet文件上传对象
				 ServletFileUpload upload = new ServletFileUpload(factory);
				 // 设置请求头编码
				 upload.setHeaderEncoding("utf-8");//解决文件乱码
				// 参数化请求头数据
				List<FileItem> pr = upload.parseRequest(request);
				// 数据遍历
				for (FileItem fileItem : pr) {
			    //如果不是普通表单数据则就是要上传文件
					if(!fileItem.isFormField()){
						//获取文件绝对路径
						String name=fileItem.getName();
						System.out.println(name);//C:\Users\Administrator\Desktop\feature.xml
						//获取文件的最后一个"\"的下标
					int index = name.lastIndexOf("\\");
			    // 通过最后一个"\"的下标截取文件名
					if(index>0){
						name = name.substring(index+1);
						System.out.println(name);//feature.xml
					}
					fileName.add("images/"+name);
					System.out.println(request.getContextPath());//  /jsp-upload
					System.out.println(request.getServletContext().getRealPath("images"));//C:/Tomcat 7.0/webapps/jsp-upload/upload
				//	获取文件夹的绝对路径创建文件对象( 在/Tomcat 7.0/webapps下创建一个“upload”文件夹用来放上传文件 )
		            File file = new File(request.getServletContext().getRealPath("images"));
		            //判断文件是否存在，如果不存在就创建一个。
		           if(!file.exists()){
		        	   file.mkdirs();
		           }
		        //   上传文件写入磁盘中( 将“upload”文件夹中名字为name的文件写入磁盘 )
		           File file2=new File(file, name);
		           fileItem.write(file2);
					}else {
						String sdf=fileItem.getFieldName();
						System.out.println(sdf);
						String value=fileItem.getString("utf-8");//解决内容乱码
						values.add(value);
					}
				}
				
				 BclassDao ed = new BclassDao();
				 ed.update(fileName,values);
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
			     	out.write("1");
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


}
