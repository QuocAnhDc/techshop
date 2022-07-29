package com.example.techshop.utils;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.entity.OrderItemEntity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import static com.example.techshop.common.CoreConstant.MAIL_SENDER;
import static com.example.techshop.common.CoreConstant.PASS_MAIL_SENDER;


public class MailUtils {

  private String userEmail;

  public MailUtils(String userEmail) {
    this.userEmail = userEmail;
  }

  public void sendMail(String content) {
    String emailSender = MAIL_SENDER;
    String password = PASS_MAIL_SENDER;
    Properties properties = this.propertiesMail();

    Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(emailSender, password);
      }
    });

    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(emailSender));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
      message.setSubject("XÁC NHẬN ĐƠN HÀNG", "utf-8");
      message.setContent(content, "text/html; charset=utf-8");
      Transport.send(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private Properties propertiesMail() {
    Properties properties = new Properties();

    properties.put("mail.smtp.auth", true);
    properties.put("mail.smtp.starttls.enable", true);
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    return properties;
  }


  public static String mailHeaders() {
    return "<!DOCTYPE html>\n"
        + "<html>\n"
        + "\n"
        + "<head lang=\"vi\">\n"
        + "    \n"
        + "    <title></title>\n"
        + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
        + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
        + "    <style type=\"text/css\">\n"
        + "      body,\n"
        + "      table,\n"
        + "      td,\n"
        + "      a {\n"
        + "        -webkit-text-size-adjust: 100%;\n"
        + "        -ms-text-size-adjust: 100%;\n"
        + "      }\n"
        + "\n"
        + "      table,\n"
        + "      td {\n"
        + "        mso-table-lspace: 0pt;\n"
        + "        mso-table-rspace: 0pt;\n"
        + "      }\n"
        + "\n"
        + "      img {\n"
        + "        -ms-interpolation-mode: bicubic;\n"
        + "      }\n"
        + "\n"
        + "      img {\n"
        + "        border: 0;\n"
        + "        height: auto;\n"
        + "        line-height: 100%;\n"
        + "        outline: none;\n"
        + "        text-decoration: none;\n"
        + "      }\n"
        + "\n"
        + "      table {\n"
        + "        border-collapse: collapse !important;\n"
        + "      }\n"
        + "\n"
        + "      body {\n"
        + "        height: 100% !important;\n"
        + "        margin: 0 !important;\n"
        + "        padding: 0 !important;\n"
        + "        width: 100% !important;\n"
        + "      }\n"
        + "\n"
        + "      a[x-apple-data-detectors] {\n"
        + "        color: inherit !important;\n"
        + "        text-decoration: none !important;\n"
        + "        font-size: inherit !important;\n"
        + "        font-family: inherit !important;\n"
        + "        font-weight: inherit !important;\n"
        + "        line-height: inherit !important;\n"
        + "      }\n"
        + "\n"
        + "      @media screen and (max-width: 480px) {\n"
        + "        .mobile-hide {\n"
        + "          display: none !important;\n"
        + "        }\n"
        + "\n"
        + "        .mobile-center {\n"
        + "          text-align: center !important;\n"
        + "        }\n"
        + "      }\n"
        + "\n"
        + "      div[style*=\"margin: 16px 0;\"] {\n"
        + "        margin: 0 !important;\n"
        + "      }\n"
        + "    </style>\n"
        + "\n"
        + "<body style=\"margin: 0 !important; padding: 0 !important; background-color: #eeeeee;\" bgcolor=\"#eeeeee; width: 1000px\" >\n"
        + "<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Money; max-height: 0px; max-width: 50px; opacity: 0; overflow: hidden;\">\n"
        + "    For what reason would it be advisable for me to think about business content? That might be little bit risky to have crew member like them.\n"
        + "</div>\n"
        + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
        + "    <tr>\n"
        + "        <td align=\"center\" style=\"background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\n"
        + "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n"
        + "                <tr>\n"
        + "                    <td align=\"center\" valign=\"top\" style=\"font-size:0; padding: 35px;\" bgcolor=\"#F44336\">\n"
        + "                        <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\">\n"
        + "                            <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n"
        + "                                <tr>\n"
        + "                                    <td align=\"left\" valign=\"top\" style=\"font-family: Money; font-size: 36px; font-weight: 800; line-height: 48px;\" class=\"mobile-center\">\n"
        + "                                        <h1 style=\"font-size: 36px; font-weight: 800; margin-left: 30px; color: #ffffff;\">Tech Shop</h1>\n"
        + "                                    </td>\n"
        + "                                </tr>\n"
        + "                            </table>\n"
        + "                        </div>\n"
        + "                        \n"
        + "                    </td>\n"
        + "                </tr>\n"
        + "                <tr>\n"
        + "                    <td align=\"center\" style=\"padding: 35px 35px 20px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n"
        + "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n"
        + "                            <tr>\n"
        + "                                <td align=\"center\" style=\"font-family: Money; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\"> <img src=\"https://img.icons8.com/carbon-copy/100/000000/checked-checkbox.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" /><br>\n"
        + "                                    <h2 style=\"font-size: 30px; font-weight: 800; line-height: 36px; color: #333333; margin: 0;\"> Đơn hàng của bạn đã được xác nhận </h2>\n"
        + "                                </td>\n"
        + "                            </tr>\n"
        + "                            <tr>\n"
        + "                                <td align=\"left\" style=\"font-family: Money; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 10px;\">\n"
        + "                                    <p style=\"font-size: 16px; font-weight: 400; line-height: 24px; color: #777777;\"> Cảm ơn bạn đã mua hàng tại Tech Shop, đơn hàng của bạn đã được nhân viên xác nhận, hãy đợi hàng về nhé ^^ </p>\n"
        + "                                </td>\n"
        + "                            </tr>\n"
        + "                            <tr>\n"
        + "                                <td align=\"left\" style=\"padding-top: 20px; width: 2000px;\">\n"
        + "                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" >\n"
        + "                                        <tr>\n"
        + "                                            <td width=\"25%\" align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Money; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\"> Sản phẩm </td>\n"
        + "                                            <td width=\"25%\" align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Money; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\"> Giá </td>\n"
        + "                                            <td width=\"25%\" align=\"center\" bgcolor=\"#eeeeee\" style=\"font-family: Money; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\"> Số lượng </td>\n"
        + "                                            <td width=\"25%\" align=\"center\" bgcolor=\"#eeeeee\" style=\"font-family: Money; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\"> Tổng </td>\n"
        + "                                        </tr>";
  }

  public static String mailContent(OrderDetailDTO orderDetail) {
    Integer orderId = orderDetail.getOrderDetailId();
    List<OrderItemEntity> orderItems = STRepoUtil.getOrderItemRepo()
        .getOrderItemsByOrderId(orderId);
    String content = "";
    Integer total = 0;
    for (OrderItemEntity item : orderItems) {

      Integer totalOfItem = item.getQuantity() * item.getProductEntity().getPrice();

      total += totalOfItem;

      content += "<tr>\n"
          + "                                            <td width=\"25%\" align=\"left\" style=\"font-family: Money; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">"
          + item.getProductEntity().getName() + "</td>\n"
          + "                                            <td width=\"25%\" align=\"left\" style=\"font-family: Money; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">"
          + formatCurrency(item.getProductEntity().getPrice()) + "</td>\n"
          + "                                            <td width=\"25%\" align=\"left\" style=\"font-family: Money; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\">"
          + item.getQuantity() + "</td>\n"
          + "                                            <td width=\"25%\" align=\"left\" style=\"font-family: Money; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\"> "
          + formatCurrency(totalOfItem) + "</td>\n"
          + "                                        </tr>";
    }

    content += "                                    </table>\n"
        + "                                </td>\n"
        + "                            </tr>\n"
        + "                            <tr>\n"
        + "                                <td align=\"left\" style=\"padding-top: 20px;\">\n"
        + "                                    <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n"
        + "                                        <tr>\n"
        + "                                            <td width=\"75%\" align=\"left\" style=\"font-family: Money; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\"> TỔNG </td>\n"
        + "                                            <td width=\"25%\" align=\"left\" style=\"font-family: Money; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\"> "
        + formatCurrency(total) + " </td>\n"
        + "                                        </tr>\n"
        + "                                    </table>\n"
        + "                                </td>\n"
        + "                            </tr>";

    return content;
  }

  public static String mailFooter() {
    String shopURI = "http://localhost:8080/";
    return "                        </table>\n"
        + "                    </td>\n"
        + "                </tr>\n"
        + "                <tr>\n"
        + "                    <td align=\"center\" height=\"100%\" valign=\"top\" width=\"100%\" style=\"padding: 0 35px 35px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n"
        + "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:660px;\">\n"
        + "                            <tr>\n"
        + "                                <td align=\"center\" valign=\"top\" style=\"font-size:0;\">\n"
        + "                                    <div style=\"display:inline-block; max-width:50%; min-width:240px; vertical-align:top; width:100%;\">\n"
        + "                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n"
        + "                                            <tr>\n"
        + "                                                <td align=\"left\" valign=\"top\" style=\"font-family: Money; font-size: 16px; font-weight: 400; line-height: 24px;\">\n"
        + "                                                    <p style=\"font-weight: 800;\">Địa chỉ giao hàng</p>\n"
        + "                                                    <p>88 Đường số 1...</p>\n"
        + "                                                </td>\n"
        + "                                            </tr>\n"
        + "                                        </table>\n"
        + "                                    </div>\n"
        + "                                    <div style=\"display:inline-block; max-width:50%; min-width:240px; vertical-align:top; width:100%;\">\n"
        + "                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n"
        + "                                            <tr>\n"
        + "                                                <td align=\"left\" valign=\"top\" style=\"font-family: Money; font-size: 16px; font-weight: 400; line-height: 24px;\">\n"
        + "                                                    <p style=\"font-weight: 800;\">Ngày giao</p>\n"
        + "                                                    <p>Chưa xác định</p>\n"
        + "                                                </td>\n"
        + "                                            </tr>\n"
        + "                                        </table>\n"
        + "                                    </div>\n"
        + "                                </td>\n"
        + "                            </tr>\n"
        + "                        </table>\n"
        + "                    </td>\n"
        + "                </tr>\n"
        + "                <tr>\n"
        + "                    <td align=\"center\" style=\" padding: 35px; background-color: #ff7361;\" bgcolor=\"#1b9ba3\">\n"
        + "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n"
        + "                            <tr>\n"
        + "                                <td align=\"center\" style=\"font-family: Money; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\">\n"
        + "                                    <h2 style=\"font-size: 24px; font-weight: 800; line-height: 30px; color: #ffffff; margin: 0;\"> Hãy mua hàng cùng Tech Shop tiếp nhé <3 </h2>\n"
        + "                                </td>\n"
        + "                            </tr>\n"
        + "                            <tr>\n"
        + "                                <td align=\"center\" style=\"padding: 25px 0 15px 0;\">\n"
        + "                                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
        + "                                        <tr>\n"
        + "                                            <td align=\"center\" style=\"border-radius: 5px;\" bgcolor=\"##f44336\"> <a href=\""
        + shopURI
        + "\" target=\"_blank\" style=\"font-size: 18px; font-family: Money; color: #ffffff; text-decoration: none; border-radius: 5px; background-color: #F44336; padding: 15px 30px; border: 1px solid #F44336; display: block;\">Quay lại</a> </td>\n"
        + "                                        </tr>\n"
        + "                                    </table>\n"
        + "                                </td>\n"
        + "                            </tr>\n"
        + "                        </table>\n"
        + "                    </td>\n"
        + "                </tr>\n"
        + "            \n"
        + "            </table>\n"
        + "        </td>\n"
        + "    </tr>\n"
        + "</table>\n"
        + "</body>\n"
        + "\n"
        + "</html>";
  }

  public static String formatCurrency(Integer price) {
    Locale locale = new Locale("vi", "VN");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
    numberFormat.setMaximumFractionDigits(0);
    return numberFormat.format(price);
  }

//  public void sendMaiRegister(){
//    String token = TokenUltils.getToken(useremail);
//    String LinkSending = WEB_URL+"/ActiveAccount?key="+token;
//    String content = "<h1>Vertication Link....</h1></br>" +
//        "<b >Your Verification Link:</b> "+LinkSending;
//    sendMail(LinkSending);
//  }
//  public void sendMaiForget(String password){
//    String token = TokenUltils.getToken(useremail);
//    String hashPassword = TokenUltils.getToken(password);
//    String LinkSending = WEB_URL+"/forgetpass?mail="+token+"&newpass="+hashPassword;
//    String content = "<h1>Confirm new password Link....</h1></br>" +
//        "<b >Your Verification to change Password Link:</b> "+LinkSending;
//    sendMail(LinkSending);
//  }

}
