package $package$.facade

import org.scalajs.dom.Element

import scala.scalajs.{LinkingInfo, js}
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-dom/client", JSImport. Namespace, "ReactDOMClient")
object ReactDOMClient extends js.Object {
  def createRoot(target: Element) : ReactDOMRoot = js.native
}
