package data;

import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;

public class PaymentData {

    private String email;
    private String token;
    private String payment_method_id;
    private Integer installments;
    private String issuer_id;
    private String description;
    private Float amount;
    private String docType;
    private String docNumber;

    public PaymentData() {
    }

    public PaymentData(String email, String token, String payment_method_id, Float amount) {
        this.email = email;
        this.token = token;
        this.payment_method_id = payment_method_id;
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getIssuer_id() {
        return issuer_id;
    }

    public void setIssuer_id(String issuer_id) {
        this.issuer_id = issuer_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Payment getPayment() {

        return new Payment().setTransactionAmount(getAmount())
                .setToken(getToken())
                .setDescription(getDescription())
                .setInstallments(getInstallments())
                .setPaymentMethodId(getPayment_method_id())
                .setIssuerId(getIssuer_id())
                .setPayer(new Payer().setEmail(getEmail()));

    }

}
