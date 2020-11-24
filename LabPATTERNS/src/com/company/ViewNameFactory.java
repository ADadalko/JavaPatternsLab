package com.company;

public class ViewNameFactory implements ViewFactory {
    @Override
    public View createView(){
        return new ViewName();
    }
}
