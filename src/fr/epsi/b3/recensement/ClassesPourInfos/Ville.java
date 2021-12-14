package fr.epsi.b3.recensement.ClassesPourInfos;

public class Ville {
    private int codeReg;
    private String nomReg;
    private String codeDep;
    private int codeCom;
    private String nomCom;
    private int popu;

    public Ville(int codeReg, String nomReg, String codeDep, int codeCom, String nomCom, int popu) {
        this.codeReg = codeReg;
        this.nomReg = nomReg;
        this.codeDep = codeDep;
        this.codeCom = codeCom;
        this.nomCom = nomCom;
        this.popu = popu;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "codeReg=" + codeReg +
                ", nomReg='" + nomReg + '\'' +
                ", codeDep=" + codeDep +
                ", codeCom=" + codeCom +
                ", nomCom='" + nomCom + '\'' +
                ", popu=" + popu +
                '}';
    }

    public int getCodeReg() {
        return codeReg;
    }

    public String getNomReg() {
        return nomReg;
    }

    public String getCodeDep() {
        return codeDep;
    }

    public int getCodeCom() {
        return codeCom;
    }

    public String getNomCom() {
        return nomCom;
    }

    public int getPopu() {
        return popu;
    }

}
