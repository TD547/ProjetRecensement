package fr.epsi.b3.recensement.ClassesPourInfos;

public class Departement {
    private String code;
    private int popu;

    public Departement(String code, int popu) {
        this.code = code;
        this.popu = popu;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "code='" + code + '\'' +
                ", popu=" + popu +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPopu() {
        return popu;
    }

    public void setPopu(int popu) {
        this.popu = popu;
    }
}
