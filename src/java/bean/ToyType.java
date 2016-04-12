/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Mesong
 */
public class ToyType {
    private int typeID;
    private String typeName;
    private String sexCategory;
    private String ageCategory;

    /**
     * @return the typeID
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * @param typeID the typeID to set
     */
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @return the sexCategory
     */
    public String getSexCategory() {
        return sexCategory;
    }

    /**
     * @param sexCategory the sexCategory to set
     */
    public void setSexCategory(String sexCategory) {
        this.sexCategory = sexCategory;
    }

    /**
     * @return the ageCategory
     */
    public String getAgeCategory() {
        return ageCategory;
    }

    /**
     * @param ageCategory the ageCategory to set
     */
    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }
}
