<?php
interface InvalidMethodModifiersInterface {
    // Invalid readonly modifier
    readonly function readonlyImplicitPublicMethodError(): void;
//  function readonlyImplicitPublicMethodError(): void;
    readonly static function readonlyImplicitPublicStaticMethodError(): void;
//  static function readonlyImplicitPublicStaticMethodError(): void;
    readonly public function readonlyPublicMethodError(): void;
//  public function readonlyPublicMethodError(): void;
    readonly public static function readonlyPublicStaticMethodError(): void;
//  public static function readonlyPublicStaticMethodError(): void;
}
