package br.usp.pcs.mvc.Venda.data;

import br.usp.pcs.mvc.Client.data.Client;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;

public class VendaPacote {
    private Client client;
    private IPackage pacote;

    public VendaPacote(Client client, IPackage pacote) {
        this.client = client;
        this.pacote = pacote;
    }

    public Client getClient() {
        return client;
    }

    public IPackage getPacote() {
        return pacote;
    }
}
