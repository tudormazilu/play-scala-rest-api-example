package services

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import guice.ApiContext
import play.api.i18n.MessagesApi

class HomeService@Inject() (@Assisted apiContext: ApiContext, messagesApi: MessagesApi) {
  def doStuff(): String = "stuff done"
}
