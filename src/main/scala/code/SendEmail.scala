package code

import javax.mail.PasswordAuthentication
import java.util.Properties
import javax.mail.internet.{InternetAddress, MimeMessage}
import javax.mail.{Transport, Authenticator, Session, Message, Address}

import net.liftweb.util.Mailer
import net.liftweb.util.Mailer.{From, Subject, To, PlainMailBodyType}

/**
 * Created by IDEA on 29/10/15.
 */
object SendEmail {
  def send_!(from: String, recipient: String, subject: String, body: String): Unit = {
    val mailTypes = List(PlainMailBodyType(body), To(recipient))
    Mailer.msgSendImpl(From(from), Subject(subject), mailTypes)
  }
}

object Email {
  def sendMail = {
    val username = "enjoyvictor1@gmail.com"
    val password = "calm2012"
    val props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com")
    props.put("mail.smtp.socketFactory.port", "465")
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
    props.put("mail.smtp.auth", "true")
    props.put("mail.smtp.port", "465")

    val session = Session.getInstance(props, new Authenticator {
      override def getPasswordAuthentication = {
        new PasswordAuthentication(username, password)
      }
    })

    try {
      val message: Message = new MimeMessage(session)
      message.setFrom(new InternetAddress(username))
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kindlychung@gmail.com").asInstanceOf[Array[Address]])
      message.setSubject("Testing subject")
      message.setText("body")
      Transport.send(message)
    } catch {
      case e: Exception => println(e)
    }
  }
}