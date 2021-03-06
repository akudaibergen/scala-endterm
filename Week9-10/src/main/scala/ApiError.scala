import akka.http.scaladsl.model.{StatusCode, StatusCodes}

final case class ApiError private(statusCode: StatusCode, message: String)

object ApiError {
  private def apply(statusCode: StatusCode, message: String): ApiError = new ApiError(statusCode, message)

  val generic: ApiError = new ApiError(StatusCodes.InternalServerError, "Unknown error.")
  val emptyTitleField: ApiError = new ApiError(StatusCodes.BadRequest, message = "Empty title.")
  val emptyDescriptionaField: ApiError = new ApiError(StatusCodes.BadRequest, message = "Empty descrtiption.")
  val dublicateTitle: ApiError = new ApiError(StatusCodes.BadRequest, message = "Title exists.")
}