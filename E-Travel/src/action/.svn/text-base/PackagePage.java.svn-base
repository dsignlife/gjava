package action;

/**
 * @author Khashayar
 */

import java.util.List;
import java.util.Map;

import bean.Package;
import bean.PackageCity;
import bean.PackageInner;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.SqlDAO;


public class PackagePage extends ActionSupport{

	private List<Package> packages;
	private List<PackageCity> packageCities;
	private List<PackageInner> packageInners;
	private Package mainPackage;
	private String value_to_submit;


	@Override
	public String execute(){

		SqlDAO sqlDAO = new SqlDAO();
		packages = sqlDAO.getPackages();
		
		return "success";
	}

	public String packageDetail() {
		
		SqlDAO sqlDAO = new SqlDAO();

		mainPackage = sqlDAO.getPackageInfo(value_to_submit);

		Map <String, Object> session = ActionContext.getContext().getSession();
		
		packageCities = sqlDAO.getPackageCityInfo(mainPackage);

		session.put("PackageCities", packageCities);
		
		packageInners = sqlDAO.getPackageInnerInfo(mainPackage);

		session.put("PackageInner", packageInners);
		
		return "package";
	}


	public List<Package> getPackages() {
		return packages;
	}


	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}


	public List<PackageCity> getPackageCities() {
		return packageCities;
	}


	public void setPackageCities(List<PackageCity> packageCities) {
		this.packageCities = packageCities;
	}


	public List<PackageInner> getPackageInners() {
		return packageInners;
	}


	public void setPackageInners(List<PackageInner> packageInners) {
		this.packageInners = packageInners;
	}


	public Package getMainPackage() {
		return mainPackage;
	}


	public void setMainPackage(Package mainPackage) {
		this.mainPackage = mainPackage;
	}


	public String getValue_to_submit() {
		return value_to_submit;
	}


	public void setValue_to_submit(String value_to_submit) {
		this.value_to_submit = value_to_submit;
	}

	
}