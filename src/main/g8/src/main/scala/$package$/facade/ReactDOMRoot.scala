package $package$.facade

import slinky.core.facade.React.Component

import scala.scalajs.{LinkingInfo, js}
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-dom/client", JSImport. Namespace, "ReactDOMClient")
class ReactDOMRoot extends js.Object {
  def render(component: Component) : Unit = js.native
}
