package com.ruchij.lambda.handlers

import java.net.HttpURLConnection

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.ruchij.lambda.models.{Request, Response}
import play.api.libs.json.{JsObject, Json}

import scala.util.Try

class Echo extends RequestHandler[Request, Response] {

  def handleRequest(request: Request, context: Context): Response =
    Response(
      HttpURLConnection.HTTP_OK,
      request.body
        .flatMap { requestBody => Try(Json.parse(requestBody)).toOption.flatMap(_.asOpt[JsObject]) }
        .getOrElse(Json.obj()),
      Map.empty
    )
}