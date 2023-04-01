package com.li.domain;

public class Emp {

//   public static void main(String[] args) throws ClassNotFoundException, IOException {
//       List<Class<?>> classes = getClasses("com.li");
//       for (Class<?> aClass : classes) {
//           System.out.println(aClass.getName());
//           Annotation[] annotations = aClass.getAnnotations();
//
//           System.out.println(Arrays.toString(annotations));
//           System.out.println("===================================");
//       }
//       // 要扫描的包
//
//
//
//   }
//    public static List<Class<?>> getClasses(String packageName) {
//        List<Class<?>> classes = new ArrayList<>();
//        String packagePath = packageName.replace('.', '/');
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        URL resource = classLoader.getResource(packagePath);
//        if (resource == null) {
//            return classes;
//        }
//        File dir = new File(resource.getFile());
//        if (!dir.isDirectory()) {
//            return classes;
//        }
//        File[] files = dir.listFiles();
//        if (files == null) {
//            return classes;
//        }
//        for (File file : files) {
//            String fileName = file.getName();
//            if (file.isDirectory()) {
//                classes.addAll(getClasses(packageName + "." + fileName));
//            } else if (fileName.endsWith(".class")) {
//                String className = packageName + '.' + fileName.substring(0, fileName.length() - 6);
//                try {
//                    classes.add(Class.forName(className));
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return classes;
//    }

    private String name;
    private Integer age;
    private String image;
    private String gender;
    private String job;

    public Emp() {
    }

    public Emp(String name, Integer age, String image, String gender, String job) {
        this.name = name;
        this.age = age;
        this.image = image;
        this.gender = gender;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
