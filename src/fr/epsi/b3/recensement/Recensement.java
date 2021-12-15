package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.ClassesPourInfos.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Recensement {
    private final ArrayList<Ville> liste;

    public Recensement() throws FileNotFoundException {
        this.liste = new ArrayList<Ville>();
        int codeReg;
        String nomReg;
        String codeDep;
        int codeCom;
        String nomCom;
        int popu;

        Scanner sc = new Scanner(new File("recensement.csv"));
        sc.useDelimiter(";");
        List<String> tabStr = new ArrayList<String>();
        while (sc.hasNext()) {
            tabStr.add(sc.next());
        }
        sc.close();

//        Dernier élément de la liste size -2;

        for (int i = 10; i < tabStr.size() - 2; i = i + 10) {
            codeReg = Integer.parseInt(tabStr.get(i).substring(tabStr.get(i).length() - 2));
            nomReg = tabStr.get(i + 1);
            codeDep = tabStr.get(i + 2);
            codeCom = Integer.parseInt(tabStr.get(i + 5));
            nomCom = tabStr.get(i + 6);
            popu = Integer.parseInt(tabStr.get(i + 9).replaceAll("\\s+", ""));

            Ville v = new Ville(codeReg, nomReg, codeDep, codeCom, nomCom, popu);
            this.liste.add(v);
        }
    }

    public int getPopuVille(String nomVille) {
        String s1 = nomVille.substring(0, 1).toUpperCase();
        nomVille = s1 + nomVille.substring(1).toLowerCase();
        AtomicInteger res = new AtomicInteger();
        res.set(-1);
        String finalNomVille = nomVille;
        this.liste.forEach(liste -> {
            if (Objects.equals(liste.getNomCom(), finalNomVille)) {
                res.set(liste.getPopu());
            }
        });
        return res.get();
    }

    public int getPopuDepartement(String dep) {
        AtomicInteger res = new AtomicInteger();
        res.set(-1);
        this.liste.forEach(liste -> {
            if (Objects.equals(liste.getCodeDep(), dep)) {
                res.set(res.get() + liste.getPopu());
            }
        });
        return res.get();
    }

    public int getPopuRegion(int reg) {
        AtomicInteger res = new AtomicInteger();
        res.set(-1);
        this.liste.forEach(liste -> {
            if (Objects.equals(liste.getCodeReg(), reg)) {
                res.set(res.get() + liste.getPopu());
            }
        });
        return res.get();
    }

    public String[] getTopPopuDepartement() {
        ArrayList<String> code = new ArrayList<String>();
        ArrayList<Departement> departements = new ArrayList<Departement>();
        ArrayList<Integer> trie = new ArrayList<Integer>();

        this.liste.forEach(liste -> {
            if (!code.contains(liste.getCodeDep())) {
                code.add(liste.getCodeDep());
                trie.add(this.getPopuDepartement(liste.getCodeDep()));
                departements.add(new Departement(liste.getCodeDep(),this.getPopuDepartement(liste.getCodeDep())));
            }
        });

        trie.sort(Collections.reverseOrder());

        String [] top = new String[10];
        for (int i = 0; i < 10; i++){
            int finalI = i;
            departements.forEach(liste -> {
                if (Objects.equals(liste.getPopu(), trie.get(finalI))) {
                    top[finalI] = liste.getCode();
                }
            });
        }
        return top;
    }


    public String[] getTopPopuRegion() {
        ArrayList<Integer> code = new ArrayList<Integer>();
        ArrayList<Region> region = new ArrayList<Region>();
        ArrayList<Integer> trie = new ArrayList<Integer>();

        this.liste.forEach(liste -> {
            if (!code.contains(liste.getCodeReg())) {
                code.add(liste.getCodeReg());
                trie.add(this.getPopuRegion(liste.getCodeReg()));
                region.add(new Region(liste.getCodeReg(),this.getPopuRegion(liste.getCodeReg()),liste.getNomReg()));
            }
        });
        trie.sort(Collections.reverseOrder());
        String [] top = new String[10];
        for (int i = 0; i < 10; i++){
            int finalI = i;
            region.forEach(liste -> {
                if (Objects.equals(liste.getPopu(), trie.get(finalI))) {
                    top[finalI] = liste.getNom();
                }
            });
        }
        return top;
    }

    public String[] getTopPopuVilleFromDep(String departement) {
        ArrayList<Integer> trie = new ArrayList<Integer>();

        this.liste.forEach(liste -> {
            if (Objects.equals(liste.getCodeDep(), departement)) {
                trie.add(liste.getPopu());
            }
        });
        if (trie.isEmpty()){
            return new String[1];
        } else {
            trie.sort(Collections.reverseOrder());
            return topDix(trie);
        }
    }

    public String[] getTopPopuVilleFromReg(int codeRegion) {
        ArrayList<Integer> trie = new ArrayList<Integer>();

        this.liste.forEach(liste -> {
            if (Objects.equals(liste.getCodeReg(), codeRegion)) {
                trie.add(liste.getPopu());
            }
        });
        if (trie.isEmpty()){
            return new String[1];
        } else {
            trie.sort(Collections.reverseOrder());
            return topDix(trie);
        }
    }

    public String[] getTopPopuVilleFromFrance() {
        ArrayList<Integer> trie = new ArrayList<Integer>();
        this.liste.forEach(liste -> {
                trie.add(liste.getPopu());
        });
        trie.sort(Collections.reverseOrder());
        return topDix(trie);
    }

    private String[] topDix(ArrayList<Integer> trie){
        String [] top = new String[10];
        for (int i = 0; i < 10; i++){
            int finalI = i;
            this.liste.forEach(liste -> {
                if (Objects.equals(liste.getPopu(), trie.get(finalI))) {
                    top[finalI] = liste.getNomCom();
                }
            });
        }
        return top;
    }
}
