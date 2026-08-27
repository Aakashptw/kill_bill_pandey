"use client";

import { useEffect } from "react";

import { useCurrentUser } from "@/hooks/use-auth";
import { Spinner } from "@/components/ui/spinner";

export default function AuthCallbackPage() {
  const { data: user, isLoading, isFetched } = useCurrentUser();

  useEffect(() => {
    if (!isFetched || isLoading) return;

    const dest = user ? "/dashboard" : "/login?error=session";
    window.location.replace(dest);
  }, [user, isLoading, isFetched]);

  return (
    <div className="flex min-h-svh flex-col items-center justify-center gap-3">
      <Spinner className="size-6" />
      <p className="text-sm text-muted-foreground">Finishing GitHub sign-in…</p>
    </div>
  );
}