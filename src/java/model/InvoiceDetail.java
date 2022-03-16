package model;

public class InvoiceDetail {

    private Invoice invoice;
    private InvoiceProduct invoiceProduct;

    public InvoiceDetail() {
        invoice = new Invoice();
        invoiceProduct = new InvoiceProduct();
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public InvoiceProduct getInvoiceProduct() {
        return invoiceProduct;
    }

    public void setInvoiceProduct(InvoiceProduct invoiceProduct) {
        this.invoiceProduct = invoiceProduct;
    }

}