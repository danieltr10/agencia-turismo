package br.usp.pcs.mvc.Package.Decorators.Interfaces;

import br.usp.pcs.mvc.Package.Interfaces.IPackage;

import java.sql.Connection;

public abstract class Content implements IPackage{
    protected IPackage content;

    public Content() {

    }

    public Content(IPackage content) {
        this.content = content;
    }

    public int getPackageId() {
        return content.getPackageId();
    }

    public String getPackageName() {
        return content.getPackageName();
    }

    public String getPackageDescription() {
        return content.getPackageDescription();
    }
}
