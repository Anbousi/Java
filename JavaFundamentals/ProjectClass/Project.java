class Project{
    private String name;
    private String description;

    public Project(){
    }
    public Project(String name){
        this.name = name;
    }

    public Project(String name, String descriptopn){
        this.name = name;
        this.description = descriptopn;
    }

    public String elevatorPitch(){
        return name +":" + description;
    }

    public String getTheName(){
        return name;
    }

    public String getTheDescription(){
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}