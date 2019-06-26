/*
 * class: Medicine
 */

package main.java.task4.model;

import java.util.HashSet;

/**
 * Represents abstract medicine.
 * @author AlesyaHlushakova
 */
public abstract class Medicine {
    /**
     * name.
     */
    private String name;
    /**
     * CAS.
     */
    private String cas;
    /**
     * drug bank.
     */
    private String drugBank;
    /**
     * pharm.
     */
    private String pharm;
    /**
     * versions.
     */
    private HashSet<Version> versions;

    /**
     * constructor.
     */
    public Medicine() {
        versions = new HashSet<Version>();
    }

    /**
     * getter for pharm.
     * @return pharmacy
     */
    public String getPharm() {
        return pharm;
    }

    /**
     * setter for pharm.
     * @param newPharm pharm
     */
    public void setPharm(final String newPharm) {
        this.pharm = newPharm;
    }

    /**
     * getter for versions.
     * @return version list.
     */
    public HashSet<Version> getVersions() {
        return versions;
    }

    /**
     * setter for versions.
     * @param newVersions versions
     */
    public void setVersions(final HashSet<Version> newVersions) {
        this.versions = newVersions;
    }

    /**
     * getter for name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name.
     * @param newName name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * getter for cas.
     * @return cas
     */
    public String getCas() {
        return cas;
    }

    /**
     * getter for cas.
     * @param newCas  cas
     */
    public void setCas(final String newCas) {
        this.cas = newCas;
    }

    /**
     * getter for drug bank.
     * @return drug bank.
     */
    public String getDrugBank() {
        return drugBank;
    }

    /**
     * setter for drug bank.
     * @param newDrugBank drug bank
     */
    public void setDrugBank(final String newDrugBank) {
        this.drugBank = newDrugBank;
    }

    /**
     * method adds version.
     * @param version version
     */
    public void addVersion(final Version version) {
        versions.add(version);
    }

    /**
     * overrides equals.
     * @param obj comparable object
     * @return is equal
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Medicine medicine = (Medicine) obj;
        if (name == null) {
            if (medicine.name != null) {
                return false;
            }
        } else if (!name.equals(medicine.name)) {
            return false;
        }
        if (cas == null) {
            if (medicine.cas != null) {
                return false;
            }
        } else if (!cas.equals(medicine.cas)) {
            return false;
        }
        if (drugBank == null) {
            if (medicine.drugBank != null) {
                return false;
            }
        } else if (!drugBank.equals(medicine.drugBank)) {
            return false;
        }
        if (versions == null) {
            if (medicine.versions != null) {
                return false;
            }
        } else if (!versions.equals(medicine.versions)) {
            return false;
        }
        return true;
    }

    /**
     * overrides hash.
      * @return hash
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += name == null ? 0 : name.hashCode();
        hashCode += cas == null ? 0 : cas.hashCode();
        hashCode += drugBank == null ? 0 : drugBank.hashCode();
        hashCode += pharm == null ? 0 : pharm.hashCode();
        for (Version version : versions) {
            hashCode += version == null ? 0 : version.hashCode();
        }
        return hashCode;
    }

    /**
     * overrides to string.
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(
                getClass().getSimpleName() + ": "
                + " name='" + name + "'"
                + " CAS='" + cas + "'"
                + " DrugBank='" + drugBank + "'"
                + "\n    pharm: " + pharm);
        for (Version version : versions) {
            output.append(version);
        }
        return output.toString();
    }
}


