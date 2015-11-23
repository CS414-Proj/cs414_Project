package cs414.a5.anvesh;

public class LocalMenu
{
	private static LocalMenu localMenu = new LocalMenu();
	private String menuXml;
	private String uid;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getMenuXml() {
		return menuXml;
	}
	public void setMenuXml(String menuXml) {
		this.menuXml = menuXml;
	}
	
	public static LocalMenu getInstance()
	{
		return localMenu;
	}
}
