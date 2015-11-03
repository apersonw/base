package org.forkjoin.apikit.model;

import java.io.File;

public class Utils {
    //	private Map<String,Package> map;
//	private Config config;
//	public Utils(Map<String,Package> map, Config config){
//		this.map = map;
//		this.config = config;
//	}
//
//	public String getJavaPack(MessageInfo m){
//		if(StringUtils.isEmpty(m.getPackageName())){
//			return config.getJavaRootPackage();
//		}else{
//			return config.getJavaRootPackage() + "." + m.getPackageName();
//		}
//	}
//
//	public String getJavaHandlerRootPackage(){
//		return config.getJavaHandlerRootPackage();
//	}
//
//	public String getAsPack(MessageInfo m){
//		if(StringUtils.isEmpty(m.getPackageName())){
//			return config.getAsRootPackage();
//		}else{
//			return config.getAsRootPackage() + "." + m.getPackageName();
//		}
//	}
//
//	public String getAsHandlerPack(MessageInfo m){
//		if(StringUtils.isEmpty(m.getPackageName())){
//			return config.getAsHandlerRootPackage();
//		}else{
//			return config.getAsHandlerRootPackage() + "." + m.getPackageName();
//		}
//	}
//
//	public String getJavaHandlerPack(MessageInfo m){
//		if(StringUtils.isEmpty(m.getPackageName())){
//			return config.getJavaHandlerRootPackage();
//		}else{
//			return config.getJavaHandlerRootPackage() + "." + m.getPackageName();
//		}
//	}
//
//	public String getJavaType(AttributeInfo a){
//		if(a.getType() == AttributeType.OTHER){
//			if(a.isArray()){
//				return "java.util.ArrayList<" +getOtherType(a, true)+ ">";
//			}else{
//				return getOtherType(a, true);
//			}
//		}else{
//			return a.getJavaTypeString();
//		}
//	}
//
//	public String getAsTypeName(AttributeInfo a){
//		if(a.getType() == AttributeType.OTHER){
//			String name = getOtherType(a, false);
//			if(a.isArray()){
//				return "Vector.<" +name+ ">";
//			}else{
//				return name;
//			}
//		}else{
//			return a.getAsTypeString();
//		}
//	}
//
//	public String getAsTypeNoArray(AttributeInfo a){
//		if(a.getType() == AttributeType.OTHER){
//			String name = getOtherType(a, false);
//			return name;
//		}else{
//			return a.getAsTypeString();
//		}
//	}
//
//	private String getOtherType(AttributeInfo a,  boolean isJava){
//		String name = a.getTypeName();
//		String pack = getPack(name);
//		name = getName(name);
//		if(StringUtils.isEmpty(pack)){
//			//先找自己，然后找默认
//			Package p = a.getMessage().getPack();
//			MessageInfo m = p.get(name);
//			if(m != null){
//				if(isJava){
//					return getJavaPack(m) + "." + name;
//				}else{
//					return getAsPack(m) + "." + name;
//				}
//			}else{
//				//找默认包的
//				p = map.get("");
//				if(p!=null){
//					m = p.get(name);
//					if(m != null){
//						if(isJava){
//							return getJavaPack(m) + "." + name;
//						}else{
//							return getAsPack(m) + "." + name;
//						}
//					}
//				}
//			}
////			if(p)
//		}else{
//			Package p = map.get(pack);
//			if(p!=null){
//				MessageInfo m = p.get(name);
//				if(m != null){
//					if(isJava){
//						return getJavaPack(m) + "." + name;
//					}else{
//						return getAsPack(m)  + "." + name;
//					}
//				}
//			}
//		}
//		return a.getTypeName();
//	}
//
//	private String getPack(String name){
//		int index = name.lastIndexOf('.');
//		if(index>-1){
//			return name.substring(0, index);
//		}else{
//			return null;
//		}
//	}
//
//	private String getName(String name){
//		int index = name.lastIndexOf('.');
//		if(index>-1){
//			return name.substring(index + 1, name.length());
//		}else{
//			return name;
//		}
//	}
//
    public final static File packToPath(String path, String packname, String name, String suffix) {
        File f = new File(path, packname.replace(".", File.separator));
        f = new File(f, name + suffix);
        return f;
    }

    public static File packToPath(String path, String packageName) {
        File f = new File(path, packageName.replace(".", File.separator));
        return f;
    }


    /**
     * 去掉对下划线的处理
     * @param str
     * @return
     */
    public static final String toClassName(String str) {
        StringBuilder sb = new StringBuilder();
        boolean isUp = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (0 == i) {
                sb.append(Character.toUpperCase(c));
            }
//            else if (c == '_') {
//                isUp = true;
//            }
            else if (isUp) {
                isUp = false;
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
//
//	public final static String formatComment(String comment,String indent){
//		return comment.replace("\n", "\r\n"+indent+"* ");
//	}
//
//	public static final String toClassName(String str){
//		StringBuilder sb=new StringBuilder();
//		boolean isUp=false;
//		for(int i=0;i<str.length();i++){
//			char c=str.charAt(i);
//			if (0==i) {
//				sb.append(Character.toUpperCase(c));
//			}else if(c=='_'){
//				isUp=true;
//			}else if(isUp){
//				isUp=false;
//				sb.append(Character.toUpperCase(c));
//			}else{
//				sb.append(c);
//			}
//		}
//		return sb.toString();
//	}
//
//	public static final String toFieldName(String str){
//		StringBuilder sb=new StringBuilder();
//		boolean isUp=false;
//		for(int i=0;i<str.length();i++){
//			char c=str.charAt(i);
//			if(i ==0){
//				c = Character.toLowerCase(c);
//			}
//			if(c=='_'){
//				isUp=true;
//			}else if(isUp){
//				isUp=false;
//				sb.append(Character.toUpperCase(c));
//			}else{
//				sb.append(c);
//			}
//		}
//		return sb.toString();
//	}
}
