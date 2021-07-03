package java12.crmapp.filter;

import javax.servlet.annotation.WebFilter;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@WebFilter(urlPatterns = "/*")
public class SitemeshFilter extends SiteMeshFilter{

}
