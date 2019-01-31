public class Man extends Person implements Comparable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void say() {
        System.out.println(this.name+"说！");
    }

    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }else if(o != null&&o instanceof Man){
            Man man = (Man)o;
            if(this.getName().compareTo(man.getName())==0){
                return 0;
            }else if(this.getName().compareTo(man.getName())>0){
                return 1;
            }else {
                return -1;
            }
        }
        return 0;
    }
}
