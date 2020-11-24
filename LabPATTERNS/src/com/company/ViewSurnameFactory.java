package com.company;

public class ViewSurnameFactory implements ViewFactory{
    @Override
    public View createView(){
        return new ViewSurname();
    }
}
