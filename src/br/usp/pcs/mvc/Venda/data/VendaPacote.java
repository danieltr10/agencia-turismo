package br.usp.pcs.mvc.Venda.data;

import br.usp.pcs.mvc.Client.data.Client;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;

public class VendaPacote {
    private Client client;
    private IPackage pacote;
    private int qtdPessoas;

    public VendaPacote(IPackage pacote) {
        this.pacote = pacote;
    }

    public VendaPacote(Client client, int qtdPessoas, IPackage pacote) {
        this.client = client;
        this.pacote = pacote;
        this.qtdPessoas = qtdPessoas;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public Client getClient() {
        return client;
    }

    public IPackage getPacote() {
        return pacote;
    }
}
